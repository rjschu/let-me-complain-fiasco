import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import * as materialModule from "@angular/material";
import {RouterModule, Routes} from "@angular/router";
import {NewComplaintComponent} from "./newComplaint/new-complaint.component";
import { LoginComponent } from './login/login.component';
import {NewUserComponent} from "./new-user/new-user.component";
import {NewUserService} from "./new-user/new-user.service";
import {DatePipe} from "@angular/common";
import {GeoService} from "./newComplaint/geo.service";
import {AgmCoreModule} from "@agm/core";
import {LoginService} from "./login/login.service";

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
      ReactiveFormsModule,BrowserAnimationsModule,
      materialModule.MatButtonModule,
      materialModule.MatCheckboxModule,
      materialModule.MatToolbarModule,
      materialModule.MatFormFieldModule,
      materialModule.MatInputModule,
      materialModule.MatSelectModule,
      materialModule.MatOptionModule,
      materialModule.MatSliderModule,
      materialModule.MatDatepickerModule,
      materialModule.MatNativeDateModule,AgmCoreModule.forRoot({
      apiKey: 'AIzaSyArXDiXNTb5Enn5tRZQwdr-MhYt5WAuQYg'
    }),
      RouterModule.forRoot(
          appRoutes,
          { enableTracing: true } // <-- debugging purposes only
      )

  ],
  providers: [
    NewUserService, DatePipe,
    GeoService, LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
