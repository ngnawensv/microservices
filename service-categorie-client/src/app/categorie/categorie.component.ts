import { CategoriesService } from './../services/categories.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css']
})
export class CategorieComponent implements OnInit {

  categorie_static:any;
  categories:any;
  errorMessage:any;
  constructor(private categorieSerice:CategoriesService) { }

  ngOnInit(): void {
    this.categorie_static=[
      {id:1, code:"Cate001",nom:"Laitier"},
      {id:2, code:"Cate002",nom:"papaterie"},
      {id:3, code:"Cate003",nom:"Pafumérie"},
      {id:4, code:"Cate004",nom:"Audio visuel"},
    ]
    this.getCategories();
  }

  getCategories():void{
    this.categorieSerice.getCategories().subscribe(
      data=>{
        this.categories=data;
      },
      err=>{
        console.log(err);
        this.errorMessage=err.error.message;
      }
    );
  }

}
