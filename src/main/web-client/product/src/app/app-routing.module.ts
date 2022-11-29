import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCategoryComponent } from './components/category/create-category/create-category.component';
import { ListCategoryComponent } from './components/category/list-category/list-category.component';
import { LoginComponent } from './components/login/login.component';
import { CreateProductComponent } from './components/product/create-product/create-product.component';
import { ListingpageComponent } from './components/product/listingpage/listingpage.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'owner/products',
    component: ListingpageComponent
  },
  {
    path: 'owner/products/create',
    component: CreateProductComponent
  },
  {
    path: 'owner/categories',
    component: ListCategoryComponent
  },
  {
    path: 'owner/categories/create',
    component: CreateCategoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  // providers: [
  //   {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: false}}
  // ]
})
export class AppRoutingModule { }
