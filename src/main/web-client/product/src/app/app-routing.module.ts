import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCategoryComponent } from './components/category/create-category/create-category.component';
import { ListCategoryComponent } from './components/category/list-category/list-category.component';
import { CreateProductComponent } from './components/product/create-product/create-product.component';
import { ListingpageComponent } from './components/product/listingpage/listingpage.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
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
  exports: [RouterModule]
})
export class AppRoutingModule { }
