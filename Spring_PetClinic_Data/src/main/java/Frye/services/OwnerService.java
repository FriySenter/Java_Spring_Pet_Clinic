package Frye.services;

import Frye.models.Owner;

public interface OwnerService extends CrudServices<Owner, Long> {

	Owner findByLastName(String lastName);

}
