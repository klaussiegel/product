import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductService } from './services/product/product.service';
import { ListingpageComponent } from './components/product/listingpage/listingpage.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateProductComponent } from './components/product/create-product/create-product.component';
import { ListCategoryComponent } from './components/category/list-category/list-category.component';
import { CreateCategoryComponent } from './components/category/create-category/create-category.component';
@NgModule({
  declarations: [
    AppComponent,
    ListingpageComponent,
    NavbarComponent,
    CreateProductComponent,
    ListCategoryComponent,
    CreateCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
