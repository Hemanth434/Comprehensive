import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { ShowDoctorComponent } from './show-doctor/show-doctor.component';
import { ShowPatientComponent } from './show-patient/show-patient.component';
import { SuccessPageComponent } from './success-page/success-page.component';

const routes: Routes = [
  {
    path:"createPatient",component:CreatePatientComponent
  },{
    path:"createDoctor",component:CreateDoctorComponent
  },
  {
    path:"success",component:SuccessPageComponent
  },
  {
    path:"showDoctor",component:ShowDoctorComponent
  },
  {
    path:"showPatient",component:ShowPatientComponent
  },
  {
    path:"home",redirectTo:'createPatient',pathMatch:"full"
  },
  {
    path:"",redirectTo:'createPatient',pathMatch:"full"
  },
  {
    path:"**",redirectTo:'createPatient',pathMatch:"full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
