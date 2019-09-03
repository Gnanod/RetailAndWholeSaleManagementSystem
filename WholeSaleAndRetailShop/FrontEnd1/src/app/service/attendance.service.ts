import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Attendance} from "../model/Attendance";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";


const URL = '/attendanceController';

@Injectable({
  providedIn:'root'
})
export class AttendanceService {

  constructor(private http : HttpClient ){}

  searchById(searchById: string){
    return this.http.get<Attendance>(environment.backend_url+ URL+'/searchById/'+searchById)
  }

  getallattendance(){
    return this.http.get<Array<Attendance>>(environment.backend_url+URL+'/getAtt');
  }

  addAttendance(att :Attendance){
    return this.http.post<Attendance>(environment.backend_url+URL+'/addAtt',att);
  }

  updateOutTime(updateTime : Attendance){
    return this.http.post<Attendance>(environment.backend_url+URL+'/updateOutTime',updateTime);
  }
  deleteAtt(dAttend : number){

    console.log("FFFFFFF"+dAttend);

    return this.http.delete<number>(environment.backend_url+URL+'/deleteAttendance/'+dAttend);

  }

  counter(){
    return this.http.get<Attendance>(environment.backend_url+URL+'/countAttend');
  }

  deletAttendace(attendanceId: number) {

    console.log("attendance"+attendanceId);
    return this.http.delete<number>(environment.backend_url+URL+'/deleteAttendance/'+attendanceId);

  }
}
