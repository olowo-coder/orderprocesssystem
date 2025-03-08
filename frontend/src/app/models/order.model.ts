// models/order.model.ts
export interface Order {
  id?: string;
  productId: string;
  productName: string;
  quantity: number;
  status?: string;
}
