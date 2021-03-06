package de.bluexs.crtrip.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.bluexs.crtrip.persistence.data.Activity;
import de.bluexs.crtrip.persistence.data.ActivityLink;
import de.bluexs.crtrip.persistence.data.Day;
import de.bluexs.crtrip.persistence.data.GMap;
import de.bluexs.crtrip.persistence.data.Gallery;
import de.bluexs.crtrip.persistence.data.GalleryImage;
import de.bluexs.crtrip.persistence.data.Intro;
import de.bluexs.crtrip.repos.ManagerRepository;
import de.bluexs.crtrip.repos.data.ActivityLinkRepository;
import de.bluexs.crtrip.repos.data.ActivityRepository;
import de.bluexs.crtrip.repos.data.DayRepository;
import de.bluexs.crtrip.repos.data.GMapRepository;
import de.bluexs.crtrip.repos.data.GalleryImageRepository;
import de.bluexs.crtrip.repos.data.GalleryRepository;
import de.bluexs.crtrip.repos.data.IntroRepository;

/**
 * 
 * @author daveyx
 * 
 */

@Component
public class DataDatabaseLoader implements CommandLineRunner {

	private final DayRepository days;
	private final IntroRepository intros;
	private final ManagerRepository managers;
	private final ActivityRepository activities;
	private final ActivityLinkRepository activityLinks;
	private final GMapRepository gMaps;
	private final GalleryRepository galleries;
	private final GalleryImageRepository images;

	@Autowired
	public DataDatabaseLoader(final DayRepository dayRepository, 
			final IntroRepository introRepository, 
			final ManagerRepository managerRepository,
			final ActivityRepository activityRepository,
			final ActivityLinkRepository activityLinkRepository,
			final GMapRepository gMapRepository,
			final GalleryRepository galleryRepository,
			final GalleryImageRepository galleryImageRepository) {
		this.days = dayRepository;
		this.intros = introRepository;
		this.managers = managerRepository;
		this.activities = activityRepository;
		this.activityLinks = activityLinkRepository;
		this.gMaps = gMapRepository;
		this.galleries = galleryRepository;
		this.images = galleryImageRepository;
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
				"https://www.daveyx.ga/images/crtrip/maejaedee.jpg",
				this.intros.save(i1));

		final Day day2 = new Day("Exploring Chiang Rai",
				null,
				"https://www.daveyx.ga/data/img/watrongkhun.jpg",
				this.intros.save(i2));
		
		this.days.save(day1);
		this.days.save(day2);
		
		final GMap gm11 = new GMap("Chiang Rai in Google Maps", "99.8325", "19.90858", "8");
		final GMap gm21 = new GMap("Wat Rong Khun in Google Maps", "99.7629538", "19.8240748", "17");
		final GMap gm22 = new GMap("Singha Park in Google Maps", "99.7433744", "19.8529981", "15");
		final GMap gm23 = new GMap("Phra That Chom Si Thep in Google Maps", "99.97350649999998", "19.8761289", "17");
		final GMap gm24 = new GMap("King Mengrai Monument in Google Maps", "99.8402678", "19.9104391", "18");
		
		this.gMaps.save(gm11);
		this.gMaps.save(gm21);
		this.gMaps.save(gm22);
		this.gMaps.save(gm23);
		this.gMaps.save(gm24);
		
		final Gallery g11 = new Gallery();
		final Gallery g21 = new Gallery();
		final Gallery g22 = new Gallery();
		final Gallery g23 = new Gallery();
		final Gallery g24 = new Gallery();
		g11.setTitle("Our trip from Phuket to Chiang Rai starts...");
		g21.setTitle("Impressions of Wat Rong Khun");
		g22.setTitle("Our impressions of Singha Park");
		g23.setTitle("Our pics from Phra That Chom Si Thep");
		g24.setTitle("The last pics of our first day in Chiang Rai");
		
		final Map<Gallery, String> galleryJsonMap = new HashMap<Gallery, String>();
		galleryJsonMap.put(g11, "json/11.json");
		galleryJsonMap.put(g21, "json/21.json");
		galleryJsonMap.put(g22, "json/22.json");
		galleryJsonMap.put(g23, "json/23.json");
		galleryJsonMap.put(g24, "json/24.json");
		
		final ObjectMapper objectMapper = new ObjectMapper();
		galleryJsonMap.forEach((key, value) -> {
			
			String jsonString;
			final List<GalleryImage> images = new ArrayList<GalleryImage>();
			try {
				final Resource resource = new ClassPathResource(value);
				InputStream resourceInputStream = resource.getInputStream();
	
				@SuppressWarnings("resource")
				final Scanner scanner = new Scanner(resourceInputStream).useDelimiter("\\A");
				jsonString = scanner.hasNext() ? scanner.next() : "";
				resourceInputStream.close();
				scanner.close();
			} catch (final IOException e1) {
				jsonString = null;
				e1.printStackTrace();
			}
			
			try {
				final JsonNode node = objectMapper.readValue(jsonString, JsonNode.class);
				node.elements().forEachRemaining(n -> {
					try {
						final GalleryImage gi = objectMapper.treeToValue(n, GalleryImage.class);
						images.add(this.images.save(gi));
					} catch (final JsonProcessingException e) {
						e.printStackTrace();
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
			key.setGalleryImages(images);
		});
				
		final Activity a11 = new Activity("เชียงราย - Chiang Rai",
				"About Chiang Rai",
				new ArrayList<String>(Arrays.asList("The Chiang Rai province is the northernmost province in Thailand. The province has borders to Mayanmar and Laos. Very popular is the Golden Triangle, where the three countries Thailand, Myanmar and Laos meet at the Mekong River.", "Chiang Rai city is the northernmost large city in Thailand.", "The nature in Chiang Rai province is amazing! A lot of mountains, beautiful landscape, lakes, nice temples and awesome waterfalls.", "Chiang Rai is not as busy as Chiang Mai and has many quiet places and nice people everywhere.")),
				gm11,
				galleries.save(g11),
				day1);
		
		final Activity a21 = new Activity("Wat Rong Khun - วัดร่องขุ่น - The White Temple",
				"About Wat Rong Khun",
				new ArrayList<String>(Arrays.asList("By the end of the 20th century, the original Wat Rong Khun was in a bad state of repair. Funds were not available for renovation. Chalermchai Kositpipat, a local artist from Chiang Rai, decided to completely rebuild the temple and fund the project with his own money.", "Nowadays this beautiful area is a tourist magnet and at least the white building is a bit crowded by  people. But nevertheless it is worth a visit if you've never been there.", "We first checked out the garden, then moved to the main building and experienced the rest of the area afterwards. Soon i got uncomfortable with the many people and we went back near our car and found a small nice Café for rest.", "For Thai people free, foreigners must pay 50 Baht entrance fee.")),
				gm21,
				galleries.save(g21),
				day2);
		
		final Activity a22 = new Activity("Singha Park - สิงห์ปาร์ค",
				"About the Singha Park",
				new ArrayList<String>(Arrays.asList(
						"Singha is a big company for beverages in Thailand. The most popular product of them is their Singha beer. Their logo, the Singha, is a powerful mythological lion, found in ancient Indian, Hindu and Thai stories. At the entrance of the park, is a big and nice sculpture of the Singha.",
						"The park is a huge area and they offer different activities which are not really cheap.",
						"Actually we wanted to book a tour with a small bus which drive many destinations in the park. But as we would had to wait more than one hour for the next bus, we decided to go by our own.",
						"We went to the tower, enjoying the nice view there. Then we took a bike for a ride. They want 150 Baht for one bike per hour. So we took a tandem bike, as i though we can save 150 Baht... I sat in the front and Jaae in the back and i am still not sure if she helped me for riding. Ride up a small hill was really exhausting as it also was very hot.",
						"With the bike we rode to the zoo area for feeding giraffes and birds. After we've giving back the bike, we had a coffee and headed up to our next destination."
						)),
				gm22,
				galleries.save(g22),
				day2);
		
		final Activity a23 = new Activity("Phra That Chom Si Thep - พระธาตุจอมศรีเทพ",
				"About Phra That Chom Si Thep",
				new ArrayList<String>(Arrays.asList(
						"Phra That Chom Si Thep is a very secret place and no tourists will go there. When we were there, we were alone, surrounded by the beautiful and silent nature. If you will ever go there, you probably will be alone up there too.", 
						"It can not be found at wikipedia or tripadvisor and i will not post an entry there. Even google maps directed us a wrong way, but with the help of some local people we found the way up the hill.", 
						"It was steep to get up, but no problem with our car. We will face a fucking steep and hardcore way when we will go to Doi Bo. The only person we met here, was a guy on a bike riding up the hill. Strong man!", 
						"I did really enjoy the silence up there and the beautiful 360° view was awesome. Watching the sunset from there was a moment we will never forget in our lifes."
						)),
				gm23,
				galleries.save(g23),
				day2);
		
		final Activity a24 = new Activity("King Mengrai Monument - อนุสาวรีย์พ่อขุนเม็งรายมหาราช",
				"About the King Mengrai Monument",
				new ArrayList<String>(Arrays.asList(
						"After so many impressions in Chiang Rai, we were very hungry and found a local restaurant not far from the King Mengrai Monument. There we had a Khao Soy, a curry noodle soup, one of my most favourite thai foods.", 
						"King Mangrai, also known as Mengrai, was the ruler and the 1st king of the Kingdom Lanna. Finally the Kindom of Lanna and the Kingdom of Siam became the Kingdom of Thailand as we know it today.", 
						"At the King Mengrai Monument local people pay respect to the 1st king of Lanna. Not many tourists visit this place in the evening although it is a very nice place."
						)),
				gm24,
				galleries.save(g24),
				day2);
		
		this.activities.save(a11);
		this.activities.save(a21);
		this.activities.save(a22);
		this.activities.save(a23);
		this.activities.save(a24);
		final ActivityLink al111 = new ActivityLink(
				"https://en.wikipedia.org/wiki/Chiang_Rai_(city)",
				"click",
				"Wanna read more about Chiang Rai? Checkout the article at Wikipedia: ",
				"",
				a11);
		
		final ActivityLink al211 = new ActivityLink(
				"https://en.wikipedia.org/wiki/Wat_Rong_Khun",
				"Wikipedia",
				"Wanna know more about Wat Rong Khun? Checkout the entry at ",
				". You can find interesting background information about the meaning of parts of the building, i.e. the bridge and the hands in front of the bridge.",
				a21);
		
		final ActivityLink al221 = new ActivityLink(
				"https://www.tripadvisor.com/Attraction_Review-g297920-d6771960-Reviews-Singha_Park-Chiang_Rai_Chiang_Rai_Province.html",
				"tripadvisor",
				"Have a look on the ",
				" page for more info about the Singha Park.",
				a22);
		
		final ActivityLink al222 = new ActivityLink(
				"http://singhapark.com/",
				"Singha Park Webpage",
				"They also hava their own ",
				". But as you can see there, it is more for advertising.",
				a22);
		
		final ActivityLink al241 = new ActivityLink(
				"https://www.tripadvisor.com/Attraction_Review-g297920-d7258244-Reviews-King_Mengrai_Monument-Chiang_Rai_Chiang_Rai_Province.html",
				"tripadvisor",
				"There is a ",
				" page for the King Mengrai Monument in Chian Rai city. When we were there in the evening, only a few local people were there.",
				a24);
		
		this.activityLinks.save(al111);
		this.activityLinks.save(al211);
		this.activityLinks.save(al221);
		this.activityLinks.save(al222);
		this.activityLinks.save(al241);
		
		SecurityContextHolder.clearContext();
	}
}
