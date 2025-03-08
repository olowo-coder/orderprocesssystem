import { Component, OnInit } from '@angular/core';
import { InventoryService } from 'src/app/services/inventory.service';
import { OrderService } from 'src/app/services/order.service';
import { Product } from 'src/app/models/product.model';
import { Order } from 'src/app/models/order.model';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {
  products: Product[] = [];
  orders: Order[] = [];
  selectedProductId!: string;
  quantity: number = 1;
  message: string = '';
  toastMessage: string = '';
  loading: boolean = false;

  constructor(
    private inventoryService: InventoryService,
    private orderService: OrderService
  ) {}

  ngOnInit(): void {
    this.fetchProducts();
    this.fetchOrders();
  }

  fetchProducts(): void {
    this.loading = true;
    this.inventoryService.getProducts().subscribe(
      (response) => {
        this.loading = false;
        if (response.success) {
          this.products = response.data;
        } else {
          console.error('Failed to fetch products:', response.message);
        }
      },
      (error) => {
        this.loading = false;
        console.error('Error fetching products:', error);
      }
    );
  }

  fetchOrders(): void {
    this.orderService.getOrders().subscribe(
      (response) => {
        if (response.success) {
          this.orders = response.data;
        } else {
          console.error('Failed to fetch orders:', response.message);
        }
      },
      (error) => console.error('Error fetching orders:', error)
    );
  }

  placeOrder(): void {
    if (!this.selectedProductId) {
      this.showMessage('Please select a product.', false);
      return;
    }

    const selectedProduct = this.products.find(p => p.id === this.selectedProductId);
    if (!selectedProduct) {
      this.showMessage('Invalid product selected.', false);
      return;
    }

    const order: Order = {
      productId: selectedProduct.id,
      productName: selectedProduct.name,
      quantity: this.quantity
    };

    this.orderService.placeOrder(order).subscribe(
      (response) => {
        if (response.success) {
          this.orders.push(order);
          this.showMessage('Order placed successfully!', true);
        } else {
          this.showMessage('Failed to place order: ' + response.message, false);
        }
      },
      (error) => {
        this.showMessage('Error: ' + (error.error?.message || error.message), false);
        console.error(error);
      }
    );
  }

  showMessage(msg: string, success: boolean): void {
    this.message = msg;
    this.toastMessage = msg;
    setTimeout(() => (this.toastMessage = ''), 3000);
    if (!success) console.error(msg);
  }
}
