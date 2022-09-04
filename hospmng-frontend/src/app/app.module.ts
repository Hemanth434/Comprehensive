import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import {HttpClientModule} from '@angular/common/http';
import { SuccessPageComponent } from './success-page/success-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { ShowDoctorComponent } from './show-doctor/show-doctor.component';
import { ShowPatientComponent } from './show-patient/show-patient.component';
@NgModule({
  declarations: [
    AppComponent,
    CreatePatientComponent,
    SuccessPageComponent,
    NavbarComponent,
    FooterComponent,
    CreateDoctorComponent,
    ShowDoctorComponent,
    ShowPatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
