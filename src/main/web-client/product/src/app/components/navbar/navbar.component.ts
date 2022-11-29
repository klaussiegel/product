import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router,) { }

  ngOnInit(): void {
  }

  toProducts() {
    this.router.navigate(['/owner/products']);
  }

  toCategories() {
    this.router.navigate(['/owner/categories']);
  }

}
