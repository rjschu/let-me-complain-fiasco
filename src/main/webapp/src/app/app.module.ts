import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
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
    materialModule.MatSliderModule,
    materialModule.MatDatepickerModule,
    materialModule.MatNativeDateModule,
    RouterModule.forRoot(
        appRoutes,
        { enableTracing: true } // <-- debugging purposes only
    )

  ],
  providers: [NewUserService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
