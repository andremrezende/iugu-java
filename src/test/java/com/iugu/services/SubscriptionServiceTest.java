package com.iugu.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.iugu.IuguConfiguration;
import com.iugu.enums.Currency;
import com.iugu.enums.IntervalType;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Customer;
import com.iugu.model.Plan;
import com.iugu.model.Subscription;
import com.iugu.responses.CustomerResponse;
import com.iugu.responses.PlanResponse;
import com.iugu.responses.SubscriptionResponse;

/**
 * Classe de teste de Assinaturas.
 * @author Andre M. Rezende
 *
 */
public class SubscriptionServiceTest {
	IuguConfiguration iuguConfiguration = new IuguConfiguration("token");

	/**
	 * Teste para criar uma nova assinatura.
	 */
	@Test
	public void testCreate() {
		CustomerService customerService = new CustomerService(iuguConfiguration);
		Customer customer = new Customer("Test");
		customer.withEmail("<adicionar_email>");

		CustomerResponse customerResponse;
		try {
			String identifier = "basic_plan";
			int valueCents = 50;
			PlanResponse planResponse = createNewPlan(identifier, identifier, "1", IntervalType.WEEKS, Currency.BRL,
					valueCents);

			if (planResponse != null && planResponse.getName().equals(identifier)) {
				customerResponse = customerService.create(customer);

				Subscription subscription = new Subscription(customerResponse.getId());

				SubscriptionService service = new SubscriptionService(iuguConfiguration);
				subscription.setPlanIdentifier(planResponse.getIdentifier());
				SubscriptionResponse subscriptionResponse = service.create(subscription);
				System.out.println(subscriptionResponse);

				subscriptionResponse = service.find(subscriptionResponse.getId());
				
				//Alterar o plano da assinatura
				identifier = "new_plan";
				int valueCents2 = 200;
				planResponse = createNewPlan(identifier, identifier, "1", IntervalType.MONTHS, Currency.BRL, valueCents2);
				subscriptionResponse = service.changePlan(subscriptionResponse.getId(), subscription);
				assertFalse(subscriptionResponse.getPriceCents() == valueCents);
			}
		} catch (IuguException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	/**
	 * Cria um novo plano.
	 * @param name Nome do plano.
	 * @param identifier Identificador do Plano.
	 * @param interval In Ciclo do Plano (Número inteiro maior que 0).
	 * @param intervalType Tipo de Interval ("weeks" ou "months")
	 * @param currency Moeda do Preço (Somente "BRL" por enquanto)
	 * @param valueCents Preço do Plano em Centavos
	 * @return PlanResponse.
	 * @author Andre M. Rezende
	 */
	private PlanResponse createNewPlan(String name, String identifier, String interval, IntervalType intervalType,
			Currency currency, int valueCents) {
		PlanService planService = new PlanService(iuguConfiguration);
		Plan plan = new Plan(identifier, identifier, interval, intervalType, currency, valueCents);
		PlanResponse planResponse = null;
		try {
			planResponse = planService.findByIdentifier(identifier);
			if (planResponse != null && planResponse.getName().equals(identifier)) {
				planResponse = planService.remove(planResponse.getId());
			}
			planResponse = planService.create(plan);
		} catch (com.iugu.exceptions.IuguException e) {
			e.printStackTrace();
		}
		return planResponse;
	}

}
