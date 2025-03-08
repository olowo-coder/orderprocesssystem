import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderFormComponent } from './components/order-form/order-form.component';
import { ProductListComponent } from './components/order-list/order-list.component';

const routes: Routes = [
  { path: 'create-order', component: OrderFormComponent },
  { path: 'products', component: ProductListComponent },
  { path: '', redirectTo: '/create-order', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
