import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserStorageService } from './auth.service.spec';


const BASIC_URL = "http://localhost:4200/";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  addCategory(categoryDto:any): Observable<any> {
    return this.http.post(BASIC_URL + 'api/admin/category', categoryDto, {
      headers: this.createAuthorizationHeader(),

    })
  }

  getAllCategories(): Observable<any>{
    return this.http.get(BASIC_URL + 'api/admin/categories', {
      headers: this.createAuthorizationHeader(),
    })
  }

  addProduct(productDto: any, formData: FormData): Observable<any> {
    return this.http.post(BASIC_URL + 'api/admin/product', productDto, {
      headers: this.createAuthorizationHeader(),

    })
  }

  updateProduct(productId:any): Observable<any> {
    return this.http.post(BASIC_URL + `api/admin/product/${productId}`, productDto, {
      headers: this.createAuthorizationHeader(),

    })
  }

  getAllProducts(): Observable<any>{
    return this.http.get(BASIC_URL + 'api/admin/products', {
      headers: this.createAuthorizationHeader(),
    })
  }

  getProductsById(productId): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/product/${productId}`, {
      headers: this.createAuthorizationHeader(),
    })
  }

  getAllProductsByName(name:any): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/search/${name}`, {
      headers: this.createAuthorizationHeader(),
    })
  }

   deleteProduct(productId:any): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/product/${productId}` , {
      headers: this.createAuthorizationHeader(),
    })
  }

  addCoupon(couponDto:any): Observable<any>{
    return this.http.post(BASIC_URL + 'api/admin/coupons', couponDto, {
      headers: this.createAuthorizationHeader(),
    })
  }

  getCoupons(): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/coupons` , {
      headers: this.createAuthorizationHeader(),
    })
  }

  getPlaceOrders(): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/placeOrders` , {
      headers: this.createAuthorizationHeader(),
    })
  }

  changeOrderStatus(orderId: number, status: string): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/order/${orderId}/${status}`, {
      headers: this.createAuthorizationHeader(),
    })
  }

    postFAQ(productId: number, faqDto: any): Observable<any>{
    return this.http.post(BASIC_URL + `api/admin/faq/${productId}`, faqDto, {
      headers: this.createAuthorizationHeader(),
  })
}


getAnalystics(): Observable<any>{
  return this.http.post(BASIC_URL + `api/admin/order/analytics`, faqDto, {
    headers: this.createAuthorizationHeader(),
})
}

  private createAuthorizationHeader(): HttpHeaders {
    return new HttpHeaders().set(
      'Authorization', 'Bearer' + UserStorageService.getToken()
    )
  }
  }

