import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category/category.service';
import { ProductService } from 'src/app/services/product/product.service';
import { InfoDialogComponent } from '../../info-dialog/info-dialog.component';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss']
})
export class CreateProductComponent implements OnInit {

  categories: any;
  createProductForm!: FormGroup;
  productName!: FormControl;
  productDescription!: FormControl;
  productPrice!: FormControl;
  productStock!: FormControl;
  productCategory!: FormControl;

  infoDialogRef?: MatDialogRef<InfoDialogComponent>

  constructor(private categoryService: CategoryService, private formBuilder: FormBuilder, private productService: ProductService,
    private router: Router,public dialog: MatDialog) { }

  ngOnInit(): void {

    this.createProductForm = this.formBuilder.group({
      productName: ['', Validators.required],
      productDescription: ['', Validators.required],
      productPrice: ['', Validators.required],
      productStock: ['', Validators.required],
      categoryId: [null,]
    });


    this.categoryService.getAll().subscribe(resp => {
      this.categories = resp;
    },
      err => {
        console.log(err);
      }
    )
  }

  createProduct() {
    this.productService.create({
      name: this.createProductForm.value.productName, description: this.createProductForm.value.productDescription
      , price: this.createProductForm.value.productPrice, stock: this.createProductForm.value.productStock, categoryId: this.createProductForm.value.categoryId
    }).subscribe(resp => {
      
      const responseMessage = resp.message

      this.infoDialogRef = this.dialog.open(InfoDialogComponent, {
        data: {
          'title': 'Information',
          'info': responseMessage
        }
      });

      this.router.navigate(['/owner/products/']);
    },
      err => { console.log(err) },

    );
  }


}
