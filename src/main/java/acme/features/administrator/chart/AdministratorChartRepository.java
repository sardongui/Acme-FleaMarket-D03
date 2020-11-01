
package acme.features.administrator.chart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("select n.category,count(n) FROM New n group by n.category order by n.category")
	Object[] findNewsByCategory();

	@Query("select (count(n)),(select count(nn) from New nn where LOWER(nn.category) NOT LIKE '%warning%') from New n where LOWER(n.category) LIKE '%warning%' group by n.category order by n.category")
	Object[] findRatioWarningNews();

	@Query("select a.discounts,count(a) FROM Advertisement a group by a.discounts order by a.discounts")
	Object[] findAdvertisementByDiscount();

}
