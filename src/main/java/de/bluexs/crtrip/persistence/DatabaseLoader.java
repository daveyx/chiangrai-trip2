package de.bluexs.crtrip.persistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.bluexs.crtrip.restrepos.DayRepository;

/**
 * 
 * @author daveyx
 * 
 */

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final DayRepository days;

	@Autowired
	public DatabaseLoader(DayRepository dayRepository) {
		this.days = dayRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		final Intro i1 = new Intro("Jaae and David experiencing the north of Thailand",
				new ArrayList<String>(Arrays.asList("Nice to welcome you here! Have fun on this webpage.",
						"This page documents our trip to the north of Thailand from 25/02/2017 until 04/03/2017.",
						"We started from Phuket on saturday, February, 25. Our flight from Phuket to Chiang Rai was scheduled at 9:25pm.",
						"There is only one one airline operating the route from Phuket to Chiang Rai: VietJetAir. Flying directly to Chiang Rai with VietJetAir was much cheaper than go to Chiang Mai with AirAsia. Furthermore we would had to go from Chiang Mai to Chiang Rai first. But anyway we will visit Chiang Mai on this trip too...")),
				"https://www.daveyx.ga/chiangrai-trip/img/th-flag.jpg",
				null);		
		
		final Intro i2 = new Intro("Summary of Day 1",
				new ArrayList<String>(Arrays.asList("On this day we first experienced Wat Rong Khun - the white temple.", 
						"After Wat Rong Khun we've been visiting the Singha park, a huge beautiful area including something like a zoo.",
						"After that we went to Phra That Chom Si Thep for the sunset view. The highlight of the day on a small mountain in beautiful nature and no people.",
						"For dinner we went to Chiang Rai city for eat Khao Soy, famous local food. As the King Mengrai Monument was nearby, we visited it too, although we were really tired already.")),
				null,
				new ArrayList<String>(Arrays.asList("https://www.daveyx.ga/data/chiangraitrip/day1/watrongkhun.jpg", 
						"https://www.daveyx.ga/data/chiangraitrip/day1/singhapark.jpg",
						"https://www.daveyx.ga/data/chiangraitrip/day1/phrathatchomsithep.jpg")));

		
		
		
//		<div id="author" className="text-center">by <a href="https://www.daveyx.ga" title="daveyx" target="_blank">daveyx</a></div>
		
		
//		Manager greg = this.managers.save(new Manager("greg", "turnquist",
//							"ROLE_MANAGER"));
//		Manager oliver = this.managers.save(new Manager("oliver", "gierke",
//							"ROLE_MANAGER"));
//
//		SecurityContextHolder.getContext().setAuthentication(
//			new UsernamePasswordAuthenticationToken("greg", "doesn't matter",
//				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
//
//		this.employees.save(new Employee("Frodo", "Baggins", "ring bearer", greg));
//		this.employees.save(new Employee("Bilbo", "Baggins", "burglar", greg));
//		this.employees.save(new Employee("Gandalf", "the Grey", "wizard", greg));
//
//		SecurityContextHolder.getContext().setAuthentication(
//			new UsernamePasswordAuthenticationToken("oliver", "doesn't matter",
//				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
//
//		this.employees.save(new Employee("Samwise", "Gamgee", "gardener", oliver));
//		this.employees.save(new Employee("Merry", "Brandybuck", "pony rider", oliver));
//		this.employees.save(new Employee("Peregrin", "Took", "pipe smoker", oliver));
//
//		SecurityContextHolder.clearContext();
	}
}

