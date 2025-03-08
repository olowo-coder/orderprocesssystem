import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private apiUrl = 'http://localhost:8082/api/inventory/products';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<{ message: string; success: boolean; data: Product[] }> {
    return this.http.get<{ message: string; success: boolean; data: Product[] }>(this.apiUrl);
  }
}
