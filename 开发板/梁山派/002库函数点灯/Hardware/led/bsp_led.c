#define HZ GPIO_OSPEED_25MHZ
#include "bsp_led.h"

void led_gpio_config(void)
{
	
	  /* ʹ��ʱ�� */
	rcu_periph_clock_enable(RCU_GPIOE);
	/* ����GPIO��ģʽ */
	gpio_mode_set(GPIOE,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_3);
	/* ����GPIO����� */
	gpio_output_options_set(GPIOE,GPIO_OTYPE_PP,HZ,GPIO_PIN_3);
	
	  /* ʹ��ʱ�� */
	rcu_periph_clock_enable(RCU_GPIOD);
	/* ����GPIO��ģʽ */
	gpio_mode_set(GPIOD,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_7);
	/* ����GPIO����� */
	gpio_output_options_set(GPIOD,GPIO_OTYPE_PP,HZ,GPIO_PIN_7);
	
	  /* ʹ��ʱ�� */
	rcu_periph_clock_enable(RCU_GPIOG);
	/* ����GPIO��ģʽ */
	gpio_mode_set(GPIOG,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_3);
	/* ����GPIO����� */
	gpio_output_options_set(GPIOG,GPIO_OTYPE_PP,HZ,GPIO_PIN_3);
	
  /* ʹ��ʱ�� */
	rcu_periph_clock_enable(RCU_GPIOA);
	/* ����GPIO��ģʽ */
	gpio_mode_set(GPIOA,GPIO_MODE_OUTPUT,GPIO_PUPD_NONE,GPIO_PIN_5);
	/* ����GPIO����� */
	gpio_output_options_set(GPIOA,GPIO_OTYPE_PP,HZ,GPIO_PIN_5);

}