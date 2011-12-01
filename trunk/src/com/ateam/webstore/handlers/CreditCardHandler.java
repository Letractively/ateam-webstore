package com.ateam.webstore.handlers;

import java.util.Collection;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.ateam.webstore.model.CreditCard;
import com.ateam.webstore.service.impl.CreditCardService;
import com.ateam.webstore.ui.Constants;
import com.ateam.webstore.ui.forms.CardEditForm;
import com.ateam.webstore.ui.forms.FormSubmission;
import com.ateam.webstore.ui.models.Visitor;
import com.ateam.webstore.ui.views.CreditCardView;
import com.ateam.webstore.ui.views.View.Contexts;

public class CreditCardHandler extends Handler {

	CreditCardService service;
	
	public CreditCardHandler(HttpServletRequest req) {
		super(req);

		service = new CreditCardService();
	}

	public Collection<CreditCard> getUsersCards() {

		Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
		
		return service.getByCustomerId(v.getCustomer().getId());
		
	}

	public CreditCard getSelectedCard() {

		Long id = Long.parseLong(req.getParameter(Parameters.CARD_ID.getId()));
		l.fine("get user card id:"+id);

		return service.getById(id);
	}

	/**
	 * 
	 * @return
	 */
	public CardEditForm getCardFromRequest() {
		
		CardEditForm cef = new CardEditForm();

		cef.setNameOnCard(req.getParameter(Constants.Parameters.CARD_NAME.getId()));
		cef.setCardNumber(req.getParameter(Constants.Parameters.CARD_ACCOUNT_NUMBER.getId()));
		cef.setExpMonth(req.getParameter(Constants.Parameters.CARD_EXPIRATION_MONTH.getId()));
		cef.setExpYear(req.getParameter(Constants.Parameters.CARD_EXPIRATION_YEAR.getId()));
		cef.setSecurityCode(req.getParameter(Constants.Parameters.CARD_SECURITY_CODE.getId()));
		cef.setCardType(req.getParameter(Constants.Parameters.CARD_TYPE.getId()));
		
		return cef;

	}
	
	public CreditCardView getCreditCardView(CreditCard card) {
		CreditCardView cv = new CreditCardView(getMainView());
		
		cv.setCreditcard(card);
		
		return cv;
	}

	/**
	 * 
	 * @return
	 */
	public FormSubmission processAddCardRequest() {
		
		//Get the form data 
		CardEditForm cf = getCardFromRequest();
		
		CreditCard card = null;
		
		//Validate and add address
		if (cf.isValid()) try {
			Visitor v = (Visitor) req.getSession().getAttribute(SESSION_ATTRIBUTE_VISITOR);
			
			AddressHandler ah = new AddressHandler(req);
			
			ah.processAddAddressRequest();
			
			card = new CreditCard(cf.getCardNumber(), cf.getExpMonth(), cf.getExpYear(), cf.getSecurityCode(), cf.getNameOnCard(), false, v.getCustomer(), ah.getAddr());
			card.setCardType(cf.getCardType());
			service.store(card);
			
		} catch (Exception e) {
			l.log(Level.WARNING, "Failed to store card", e);
			cf.setResultMessage("Could not store card");
		}
		
		String context = req.getParameter(Parameters.CONTEXT.getId());
		l.info("context="+context);
		
		if (context != null && context.equals(Contexts.ORDER_PAYMENT.getId())) {
			OrderHandler oh = new OrderHandler(req);
			cf.setResultView(oh.getOrderPaymentView());
			return cf;
		}
		else {
			cf.setResultView(getCreditCardView(card));
		}
		
		return cf;
	}

	
}
