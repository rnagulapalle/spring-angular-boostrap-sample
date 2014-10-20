package com.eoutletz.test;


import org.junit.Test;
import org.junit.runner.RunWith;

import com.eoutletz.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {
	@Test
public void contextLoads() {
}
}