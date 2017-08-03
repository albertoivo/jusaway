import { AcaoComponent, AreaComponent } from './cadastrobasico/cadastrobasico.component';

import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard',  component: AppComponent },
  { path: 'acao',  component: AcaoComponent },
  { path: 'area',  component: AreaComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
