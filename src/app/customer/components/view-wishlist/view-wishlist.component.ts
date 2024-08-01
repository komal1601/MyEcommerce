import { Component } from '@angular/core';

@Component({
  selector: 'app-view-wishlist',
  templateUrl: './view-wishlist.component.html',
  styleUrl: './view-wishlist.component.scss'
})
export class ViewWishlistComponent {

  products: any[] = [];

  constructor(private customerService: CustomerService){}


  ngOnInit(){
    this.getWishlistByUserId();

  }
  getWishlistByUserId(){
    this.customerService.getWishlistByUserId().subscribe(res=>{
      res.forEach(element =>{
        element.processedImg = 'data:image/jpeg;base64', + element.returnedImg;
        this.products.push(element);
      });

    })
  }

}
