import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';
import { ConfirmDialog } from '../../confirmation-dialog/confirm-dialog';
import { InfoDialogComponent } from '../../info-dialog/info-dialog.component';

@Component({
  selector: 'app-product',
  templateUrl: './listingpage.component.html',
  styleUrls: ['./listingpage.component.scss']
})
export class ListingpageComponent implements OnInit {

  public products: any;
  confirmDialogRef?: MatDialogRef<ConfirmDialog>
  infoDialogRef?: MatDialogRef<InfoDialogComponent>

  constructor(private productService: ProductService
    , private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAll().subscribe(resp => {
      this.products = resp;
    },
      err => { console.log(err) },
      () => { console.log("Products Loaded", this.products) }
    );
  }

  navigateToCreate() {
    this.router.navigate(['/owner/products/create']);
  }

  deleteProduct(id: number) {
    this.productService.delete(id).subscribe(resp => {

      const responseMessage = resp.message

      this.infoDialogRef = this.dialog.open(InfoDialogComponent, {
        data: {
          'title': 'Information',
          'info': responseMessage
        }
      });

      this.getAll();
    },
      err => {
        console.log(err)
      })
  }


  openDialog(id: number) {
    this.confirmDialogRef = this.dialog.open(ConfirmDialog, {
      disableClose: true,
      data: {
        'title': 'Delete Product',
        'name': 'Product'
      }
    });

    this.confirmDialogRef.afterClosed().subscribe(resp => {

      if (resp) {
        this.deleteProduct(id);
      }

    });

  }


}
