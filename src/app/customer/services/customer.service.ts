import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserStorageService } from '../../service/auth.service.spec';

const BASIC_URL = "http://localhost:4200/";
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  http: any;

  constructor() { }

  getAllProducts(): Observable<any>{
    return this.http.get(BASIC_URL + 'api/admin/products', {
      headers: this.createAuthorizationHeader(),
    })
  }

  getAllProductsByName(name:any): Observable<any>{
    return this.http.get(BASIC_URL + `api/admin/search/${name}`, {
      headers: this.createAuthorizationHeader(),

    }) 
  }

  addToCart(productId:any): Observable<any>{
    const cartDto = {
      productId : productId,
      userId: UserStorageService.getUserId()
    }
    return this.http.post(BASIC_URL + `api/customer/cart`, cartDto, {
      headers: this.createAuthorizationHeader(),
    })
  }
  
  increaseProductQuantity(productId:any): Observable<any>{
    const cartDto = {
      productId : productId,
      userId: UserStorageService.getUserId()
    }
    return this.http.post(BASIC_URL + `api/customer/addition`, cartDto, {
      headers: this.createAuthorizationHeader(),
    })
  }

  decreaseProductQuantity(productId:any): Observable<any>{
    const cartDto = {
      productId : productId,
      userId: UserStorageService.getUserId()
    }
    return this.http.post(BASIC_URL + `api/customer/deduction`, cartDto, {
      headers: this.createAuthorizationHeader(),
    })
  }

  getCartByUserId(): Observable<any>{
    const userId = UserStorageService.getUserId()
    return this.http.get(BASIC_URL + `api/customer/cart/${userId}`,{
      headers: this.createAuthorizationHeader(),
    })
  }

  
 applyCoupon(code:any): Observable<any>{
    const userId = UserStorageService.getUserId()
    return this.http.get(BASIC_URL + `api/customer/coupon/${userId}/${code}` ,{
      headers: this.createAuthorizationHeader(),
    })
  }

    
 placeOrder(code:any): Observable<any>{
  OrderDto.userId = UserStorageService.getUserId()
  return this.http.post(BASIC_URL + `api/customer/placeOrder` ,{
    headers: this.createAuthorizationHeader(),
  })
}

getOrdersByUserId(): Observable<any>{
  const userId = UserStorageService.getUserId()
  return this.http.get(BASIC_URL + `api/customer/myOrders/${userId}` ,{
    headers: this.createAuthorizationHeader(),
  })
}

getOrderedProducts(orderId:number): Observable<any>{
  return this.http.get(BASIC_URL + `api/customer/ordered_products/${orderId}` ,{
    headers: this.createAuthorizationHeader(),
  })
}

giveReview(reviewDto:any): Observable<any>{
  return this.http.get(BASIC_URL + `api/customer/review`, reviewDto ,{
    headers: this.createAuthorizationHeader(),
  })
}

getProductDetailById(productId: number) : Observable<any>{
  return this.http.get(BASIC_URL + `api/customer/product/${productId}` ,{
    headers: this.createAuthorizationHeader(),
  })
}

addProductToWishlist(wishlistDto:any) : Observable<any>{
  return this.http.get(BASIC_URL + `api/customer/wishlist` , wishlistDto,{
    headers: this.createAuthorizationHeader(),
  })
}

getWishlistByUserId() : Observable<any>{
  const userId = UserStorageService.getUserId()
  return this.http.get(BASIC_URL + `api/customer/wishlist/${userId}` ,{
    headers: this.createAuthorizationHeader(),
  })
}
  

  private createAuthorizationHeader(): HttpHeaders {
      return new HttpHeaders().set(
        'Authorization','Bearer' + UserStorageService.getToken()
      )
  }
}
