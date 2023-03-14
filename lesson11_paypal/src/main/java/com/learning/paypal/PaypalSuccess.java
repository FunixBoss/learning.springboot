package com.learning.paypal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

public class PaypalSuccess {

	public static PaypalResult getPaypal(HttpServletRequest request, PaypalConfig config) {
		PaypalResult paypalResult = new PaypalResult();
		String[] temp = null;
		String res = "";
		try {
			String transId = request.getParameter("tx");
			String authToken = config.getAuthToken();
			String query = "cmd=_notify-synch&tx=" + transId +  "&at=" + authToken;
			String url = config.getPostUrl();
			URL u = new URL(url);
			HttpURLConnection req = (HttpURLConnection) u.openConnection();
			req.setRequestMethod("POST");
			req.setDoOutput(true);
			req.setDoInput(true);
			req.setRequestProperty("Content-Type", "application/x-www/form-urlencoded");
			req.setFixedLengthStreamingMode(query.length());
			
			OutputStream outputStream = req.getOutputStream();
			outputStream.write(query.getBytes());
			outputStream.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
			res = in.readLine();
			if(res.equals("SUCCESS")) {
				while((res = in.readLine()) != null) {
				    temp = res.split("=");
				    if(temp.length == 1) continue;
				    temp[1] = URLDecoder.decode(temp[1], "UTF-8");
				    switch (temp[0]) {
				    case "mc_gross":
		                paypalResult.setMc_gross(temp[1]);
		                break;
		            case "protection_eligibility":
		                paypalResult.setProtection_eligibility(temp[1]);
		                break;
		            case "address_status":
		                paypalResult.setAddress_status(temp[1]);
		                break;
		            case "tax":
		                paypalResult.setTax(temp[1]);
		                break;
		            case "payer_id":
		                paypalResult.setPayer_id(temp[1]);
		                break;
		            case "address_street":
		                paypalResult.setAddress_street(temp[1]);
		                break;
		            case "payment_date":
		                paypalResult.setPayment_date(temp[1]);
		                break;
		            case "payment_status":
		                paypalResult.setPayment_status(temp[1]);
		                break;
		            case "charset":
		                paypalResult.setCharset(temp[1]);
		                break;
		            case "address_zip":
		                paypalResult.setAddress_zip(temp[1]);
		                break;
		            case "mc_shipping":
		                paypalResult.setMc_shipping(temp[1]);
		                break;
		            case "mc_handling":
		                paypalResult.setMc_handling(temp[1]);
		                break;
		            case "first_name":
		                paypalResult.setFirst_name(temp[1]);
		                break;
		            case "mc_fee":
		                paypalResult.setMc_fee(temp[1]);
		                break;
		            case "address_country_code":
		                paypalResult.setAddress_country_code(temp[1]);
		                break;
		            case "address_name":
		                paypalResult.setAddress_name(temp[1]);
		                break;
		            case "custom":
		                paypalResult.setCustom(temp[1]);
		                break;
		            case "payer_status":
		                paypalResult.setPayer_status(temp[1]);
		                break;
		            case "business":
		                paypalResult.setBusiness(temp[1]);
		                break;
		            case "address_country":
		                paypalResult.setAddress_country(temp[1]);
		                break;
		            case "num_cart_items":
		                paypalResult.setNum_cart_items(temp[1]);
		                break;
		            case "mc_handling1":
		                paypalResult.setMc_handling1(temp[1]);
		                break;
		            case "mc_handling2":
		                paypalResult.setMc_handling2(temp[1]);
		                break;
		            case "address_city":
		                paypalResult.setAddress_city(temp[1]);
		                break;
		            case "payer_email":
		                paypalResult.setPayer_email(temp[1]);
		                break;
		            case "mc_shipping1":
		                paypalResult.setMc_shipping1(temp[1]);
		                break;
		            case "mc_shipping2":
		                paypalResult.setMc_shipping2(temp[1]);
		                break;
		            case "tax1":
		                paypalResult.setTax1(temp[1]);
		                break;
		            case "tax2":
		                paypalResult.setTax2(temp[1]);
		                break;
		            case "txn_id":
		                paypalResult.setTxn_id(temp[1]);
		                break;
		            case "payment_type":
		                paypalResult.setPayment_type(temp[1]);
		                break;
		            case "last_name":
		                paypalResult.setLast_name(temp[1]);
		                break;
		            case "address_state":
		                paypalResult.setAddress_state(temp[1]);
		                break;
		            case "receiver_email":
		                paypalResult.setReceiver_email(temp[1]);
		                break;
					case "payment_fee":
		                paypalResult.setPayment_fee(temp[1]);
					case "receiver_id":
						paypalResult.setReceiver_id(temp[1]);
						break;
					case "pending_reason":
						paypalResult.setPending_reason(temp[1]);
						break;
					case "txn_type":
						paypalResult.setTxn_type(temp[1]);
						break;
					case "mc_gross_1":
						paypalResult.setMc_gross_1(temp[1]);
						break;
					case "mc_currency":
						paypalResult.setMc_currentcy(temp[1]);
						break;
					case "mc_gross_2":
						paypalResult.setMc_gross_2(temp[1]);
						break;
					case "residence_country":
						paypalResult.setResidence_country(temp[1]);
						break;
					case "transaction_subject":
						paypalResult.setTransaction_subject(temp[1]);
						break;
					case "payment_gross":
						paypalResult.setPayment_gross(temp[1]);
						break;
					default:
						break;
				    }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			paypalResult = null;
		}
		
		return paypalResult;
	}
}
