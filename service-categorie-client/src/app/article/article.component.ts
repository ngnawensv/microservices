import { ArticlesService } from './../services/articles.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articles: any;
  errorMessage:any;
  constructor(private articleService:ArticlesService) { }

  ngOnInit(): void {
    this.articleService.getArticles()
    .subscribe(
      data=>{
        this.articles=data
      },
      err=>{
        this.errorMessage=err.error.message;
        console.log(err);
      }
    )
  }

}
