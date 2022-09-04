import { Component, OnInit } from '@angular/core';
import { HospitalServiceService } from '../service/hospital-service.service';
import { Docter } from '../model/docter';
@Component({
  selector: 'app-show-doctor',
  templateUrl: './show-doctor.component.html',
  styleUrls: ['./show-doctor.component.css']
})
export class ShowDoctorComponent implements OnInit {

  doc:Docter = new Docter()
  doctors?:Docter[];
  nam:string | undefined=this.doc.name;
  speciali?:string;
  pattre?:number;

  constructor(private hospitalServiceService:HospitalServiceService) {
    this.getDoctors();
   }

  ngOnInit(): void {
    
  }
  public getDoctors(){
    this.hospitalServiceService.getDoctorList().subscribe(data=>{
      this.doctors=data;

    })
  }
  public getDoctorById(a:number){
    this.hospitalServiceService.getDoctorById(a).subscribe(data=>{
      this.doc=data;
      // console.log(this.doc);
      // console.log(data.id)
    })
  }

  getDetails(a:string|undefined){
    // console.log(this.getDoctors())
    // console.warn(typeof(Number(a)));
    this.getDoctorById(Number(a));
  }

}
