import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.scss']
})
export class ListCategoryComponent implements OnInit {


  public categories: any;

  constructor(private categoryService: CategoryService
    , private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.categoryService.getAll().subscribe(data => {
      this.categories = data;
    },
      err => { console.log(err) },
      () => { console.log("Categories Loaded", this.categories) }
    );
  }

  navigateToCreate(){
    this.router.navigate(['/owner/categories/create']);
  }
}
