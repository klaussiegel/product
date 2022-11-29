import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category/category.service';
import { InfoDialogComponent } from '../../info-dialog/info-dialog.component';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.scss']
})
export class CreateCategoryComponent implements OnInit {

  createCategoryForm!: FormGroup;
  infoDialogRef?: MatDialogRef<InfoDialogComponent>

  constructor(private categoryService: CategoryService, private router: Router, private formBuilder: FormBuilder, public dialog: MatDialog) { }

  ngOnInit(): void {

    this.createCategoryForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
    });

  }

  createCategory() {
    this.categoryService.create({ name: this.createCategoryForm.value.name, description: this.createCategoryForm.value.description }).subscribe(resp => {
      
      const responseMessage = resp.message

      this.infoDialogRef = this.dialog.open(InfoDialogComponent, {
        data: {
          'title': 'Information',
          'info': responseMessage
        }
      });

      this.router.navigate(['/owner/categories/']);
    },
      err => { console.log(err) },

    );
  }

}
