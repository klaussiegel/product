import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './listingpage.component.html',
  styleUrls: ['./listingpage.component.scss']
})
export class ListingpageComponent implements OnInit {

  public products: any;

  constructor(private productService: ProductService
    , private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    },
      err => { console.log(err) },
      () => { console.log("Products Loaded", this.products) }
    );
  }

  navigateToCreate(){
    this.router.navigate(['/owner/products/create']);
  }

}
