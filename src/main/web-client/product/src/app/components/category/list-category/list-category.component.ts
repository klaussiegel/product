import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category/category.service';
import { ConfirmDialog } from '../../confirmation-dialog/confirm-dialog';
import { InfoDialogComponent } from '../../info-dialog/info-dialog.component';

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.scss']
})
export class ListCategoryComponent implements OnInit {

  confirmDialogRef: MatDialogRef<ConfirmDialog> | undefined
  infoDialogRef: MatDialogRef<InfoDialogComponent> | undefined
  public categories: any;

  constructor(private categoryService: CategoryService
    , private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.categoryService.getAll().subscribe(data => {
      this.categories = data;
    },
      err => { console.log(err) },
      () => { console.log("Categories Loaded") }
    );
  }

  navigateToCreate() {
    this.router.navigate(['/owner/categories/create']);
  }

  deleteCategory(id: any) {
    this.categoryService.delete(id).subscribe(data => {
      
      const responseMessage = data.message
      
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
        'title': 'Delete Category',
        'name': 'Category'
      }
    });

    this.confirmDialogRef.afterClosed().subscribe(result => {

      if (result) {
        this.deleteCategory(id);
      }

    });

  }

}
