import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms'; // ✅ Import FormsModule
import { HttpClientModule } from '@angular/common/http';
import { OrderFormComponent } from './components/order-form/order-form.component';
import { OrderListComponent } from './components/order-list/order-list.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderFormComponent,
    OrderListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, // ✅ Add this line
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
