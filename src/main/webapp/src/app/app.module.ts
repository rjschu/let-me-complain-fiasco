import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import * as materialModule from "@angular/material";
import {RouterModule, Routes} from "@angular/router";
import {NewUserComponent} from "app/newUser/new-user.component";
import {NewComplaintComponent} from "./newComplaint/new-complaint.component";
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'new-user', component: NewUserComponent },
    { path: 'new-complaint', component: NewComplaintComponent },
    { path: '', redirectTo: '/login', pathMatch: 'full'}

];

@NgModule({
  declarations: [
    AppComponent,
      NewComplaintComponent,
      NewUserComponent,
      LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
      BrowserAnimationsModule,
      materialModule.MatButtonModule,
      materialModule.MatCheckboxModule,
      materialModule.MatToolbarModule,
      materialModule.MatFormFieldModule,
      materialModule.MatInputModule,
      materialModule.MatSelectModule,
      materialModule.MatOptionModule,
      RouterModule.forRoot(
          appRoutes,
          { enableTracing: true } // <-- debugging purposes only
      )

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }