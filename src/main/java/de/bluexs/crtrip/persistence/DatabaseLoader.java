package de.bluexs.crtrip.persistence;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import de.bluexs.crtrip.repos.DayRepository;
import de.bluexs.crtrip.repos.IntroRepository;
import de.bluexs.crtrip.repos.ManagerRepository;

/**
 * 
 * @author daveyx
 * 
 */

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final DayRepository days;
	private final IntroRepository intros;
	private final ManagerRepository managers;

	@Autowired
	public DatabaseLoader(final DayRepository dayRepository, final IntroRepository introRepository, final ManagerRepository managerRepository) {
		this.days = dayRepository;
		this.intros = introRepository;
		this.managers = managerRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		@SuppressWarnings("unused")
		final Manager daveyx = this.managers.save(new Manager("David", "doesn't matter", "ADMIN"));

		SecurityContextHolder.getContext().setAuthentication(
			new UsernamePasswordAuthenticationToken("David", "doesn't matter",
				AuthorityUtils.createAuthorityList("ADMIN")));
		
		final Intro i1 = new Intro("Jaae and David experiencing the north of Thailand",
				new ArrayList<String>(Arrays.asList("Nice to welcome you here! Have fun on this webpage.",
						"This page documents our trip to the north of Thailand from 25/02/2017 until 04/03/2017.",
						"We started from Phuket on saturday, February, 25. Our flight from Phuket to Chiang Rai was scheduled at 9:25pm.",
						"There is only one one airline operating the route from Phuket to Chiang Rai: VietJetAir. Flying directly to Chiang Rai with VietJetAir was much cheaper than go to Chiang Mai with AirAsia. Furthermore we would had to go from Chiang Mai to Chiang Rai first. But anyway we will visit Chiang Mai on this trip too...")),
				"https://www.daveyx.ga/chiangrai-trip/img/th-flag.jpg",
				"Amazing Thailand",
				null);		
		
		final Intro i2 = new Intro("Summary of Day 1",
				new ArrayList<String>(Arrays.asList("On this day we first experienced Wat Rong Khun - the white temple.", 
						"After Wat Rong Khun we've been visiting the Singha park, a huge beautiful area including something like a zoo.",
						"After that we went to Phra That Chom Si Thep for the sunset view. The highlight of the day on a small mountain in beautiful nature and no people.",
						"For dinner we went to Chiang Rai city for eat Khao Soy, famous local food. As the King Mengrai Monument was nearby, we visited it too, although we were really tired already.")),
				null,
				null,
				new ArrayList<String>(Arrays.asList("https://www.daveyx.ga/data/chiangraitrip/day1/watrongkhun.jpg", 
						"https://www.daveyx.ga/data/chiangraitrip/day1/singhapark.jpg",
						"https://www.daveyx.ga/data/chiangraitrip/day1/phrathatchomsithep.jpg")));

		final Day day1 = new Day("Trip to Chiang Rai with Jaae and David",
				"<div id=\"author\" className=\"text-center\">by <a href=\"https://www.daveyx.ga\" title=\"daveyx\" target=\"_blank\">daveyx</a></div>",
				"https://www.daveyx.ga/chiangrai-trip/img/maejaedee.jpg",
				this.intros.save(i1));

		final Day day2 = new Day("Exploring Chiang Rai",
				null,
				"https://www.daveyx.ga/data/img/watrongkhun.jpg",
				this.intros.save(i2));
		
		this.days.save(day1);
		this.days.save(day2);

		SecurityContextHolder.clearContext();
	}
}

