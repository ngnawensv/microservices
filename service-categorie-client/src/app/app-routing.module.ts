import { ArticleComponent } from './article/article.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategorieComponent } from './categorie/categorie.component';


const routes: Routes = [
  {path:"categories", component:CategorieComponent},
  {path:"articles", component:ArticleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
