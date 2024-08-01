import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DemoAngularMaterialModule } from './demoangularmaterialmodule';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PostCategoryComponent } from './service/post-category/post-category.component';
import { TrackOrderComponent } from './track-order/track-order.component';





@NgModule({
declarations: [

    AppComponent,
      LoginComponent,
      SignupComponent,
      PostCategoryComponent,
      TrackOrderComponent
],

imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DemoAngularMaterialModule,
    FormsModule,
    ReactiveFormsModule,
],

providers : [],
bootstrap : [AppComponent]

})

export class AppModule{ }