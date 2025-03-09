import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private apiUrl = `${environment.inventoryApiUrl}/api/inventory/products`;

  constructor(private http: HttpClient) {}

  getProducts(): Observable<{ message: string; success: boolean; data: Product[] }> {
    return this.http.get<{ message: string; success: boolean; data: Product[] }>(this.apiUrl);
  }
}
