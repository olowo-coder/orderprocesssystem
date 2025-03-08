import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/models/order.model';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  orders: Order[] = [];

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.fetchOrders();
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
}
