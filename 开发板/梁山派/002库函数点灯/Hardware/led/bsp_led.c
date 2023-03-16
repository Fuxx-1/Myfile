#define HZ GPIO_OSPEED_25MHZ
#include "bsp_led.h"

void led_gpio_config(void)
{
	
	  /* 使能时钟 */
	rcu_periph_clock_enable(RCU_GPIOE);
	/* 配置GPIO的模式 */
	gpio_mode_set(GPIOE,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_3);
	/* 配置GPIO的输出 */
	gpio_output_options_set(GPIOE,GPIO_OTYPE_PP,HZ,GPIO_PIN_3);
	
	  /* 使能时钟 */
	rcu_periph_clock_enable(RCU_GPIOD);
	/* 配置GPIO的模式 */
	gpio_mode_set(GPIOD,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_7);
	/* 配置GPIO的输出 */
	gpio_output_options_set(GPIOD,GPIO_OTYPE_PP,HZ,GPIO_PIN_7);
	
	  /* 使能时钟 */
	rcu_periph_clock_enable(RCU_GPIOG);
	/* 配置GPIO的模式 */
	gpio_mode_set(GPIOG,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_3);
	/* 配置GPIO的输出 */
	gpio_output_options_set(GPIOG,GPIO_OTYPE_PP,HZ,GPIO_PIN_3);
	
  /* 使能时钟 */
	rcu_periph_clock_enable(RCU_GPIOA);
	/* 配置GPIO的模式 */
	gpio_mode_set(GPIOA,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_5);
	/* 配置GPIO的输出 */
	gpio_output_options_set(GPIOA,GPIO_OTYPE_PP,HZ,GPIO_PIN_5);

}