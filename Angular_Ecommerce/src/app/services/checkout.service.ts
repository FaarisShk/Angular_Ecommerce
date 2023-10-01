import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Purhcase } from '../common/purhcase';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private purchaseUrl = 'http://localhost:4555/api/checkout/purchase';

  constructor(private httpClient: HttpClient) { }

  placeOrder(purchase: Purhcase): Observable<any> {
    return this.httpClient.post<Purhcase>(this.purchaseUrl, purchase);    
  }
}
