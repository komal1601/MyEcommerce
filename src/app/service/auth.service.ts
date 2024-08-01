import { map, Observable } from "rxjs";
import { Injectable } from '@angular/core';
import { HttpHeaders } from "@angular/common/http";

const BASIC_URL = "http://localhost:4200/";

@Injectable({
    providedIn : 'root'
})
export class AuthService {
   userStorageService: any;
    http: any;

      
   login(username: string, password: string): any {
        const headers = new HttpHeaders().set('content-Type', 'application/json');
        const body={username, password};
    
        return this.http.post(BASIC_URL + 'authenticate' , body, { headers, observe: 'response'}).pipe(
          map((res) => {
            const token = res.headers.get('authorization').substring(7);
            const user = res.body;
            if(token && user) {
                this.userStorageService.saveToken(token);
                this.userStorageService.saveUser(user);
                return true;
            }
            return false;
    })
     )
    
    }

    getOrderByTrackingId(trackingId: number): Observable<any>{
        return this.http.get(BASIC_URL + `order/${trackingId}`);
    }
}