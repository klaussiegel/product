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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { ConfirmDialog } from './components/confirmation-dialog/confirm-dialog';
import { MatDialogModule } from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';
import { InfoDialogComponent } from './components/info-dialog/info-dialog.component';
import { LoginComponent } from './components/login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    ListingpageComponent,
    NavbarComponent,
    CreateProductComponent,
    ListCategoryComponent,
    CreateCategoryComponent,
    ConfirmDialog,
    InfoDialogComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
		MatDialogModule,
    MatToolbarModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
