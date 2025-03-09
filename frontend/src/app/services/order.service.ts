import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private apiUrl = `${environment.orderApiUrl}/api/orders`;

  constructor(private http: HttpClient) {}

  placeOrder(order: Order): Observable<{ message: string; success: boolean }> {
    return this.http.post<{ message: string; success: boolean }>(this.apiUrl, order);
  }

  getOrders(): Observable<{ message: string; success: boolean; data: Order[] }> {
    return this.http.get<{ message: string; success: boolean; data: Order[] }>(this.apiUrl);
  }
}
