/*!
    \file    main.c
    \brief   led spark with systick

    \version 2016-08-15, V1.0.0, firmware for GD32F4xx
    \version 2018-12-12, V2.0.0, firmware for GD32F4xx
    \version 2020-09-30, V2.1.0, firmware for GD32F4xx
    \version 2022-03-09, V3.0.0, firmware for GD32F4xx
*/

/*
    Copyright (c) 2022, GigaDevice Semiconductor Inc.

    Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    1. Redistributions of source code must retain the above copyright notice, this
       list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright notice,
       this list of conditions and the following disclaimer in the documentation
       and/or other materials provided with the distribution.
    3. Neither the name of the copyright holder nor the names of its contributors
       may be used to endorse or promote products derived from this software without
       specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
OF SUCH DAMAGE.
*/
#define c_second 1000
#define c_minute 60 * c_second
#define c_hour 60 * c_minute
#include "gd32f4xx.h"
#include "systick.h"
#include <stdio.h>
#include "main.h"
#include "bsp_led.h"

int number = 0;

void plus(int number);
void waterled();
void openLED(int no, int closeWithDelay);

/*!
    \brief    main function
    \param[in]  none
    \param[out] none
    \retval     none
*/
int main(void)
{
		
    systick_config();
	
	  led_gpio_config();  // led³õÊ¼»¯

   // gpio_bit_set(GPIOD,GPIO_PIN_7);
	 // gpio_bit_reset(GPIOD,GPIO_PIN_7);
  	//gpio_bit_write(PORT_LED2,PIN_LED2,RESET);

    while(1) {
			number++;
			//waterled(100);
			plus(number);
    }
}

void waterled(int delay) 
{
	openLED(1, delay);
	openLED(2, delay);
	openLED(3, delay);
	openLED(4, delay);
	openLED(3, delay);
	openLED(2, delay);
}

void plus(int number) {
	if (number / 1 % 2) openLED(1, -1);
	if (number / 2 % 2) openLED(2, -1);
	if (number / 4 % 2) openLED(3, -1);
	if (number / 8 % 2) openLED(4, -1);
	delay_1ms(2000);
	openLED(1, 0);
	openLED(2, 0);
	openLED(3, 0);
	openLED(4, 0);
}


void openLED(int no, int closeWithDelay) 
{
	//OPEN
	switch (no) {
		case 1 :
			gpio_bit_write(GPIOE,GPIO_PIN_3,SET);
			break;
		case 2 :
			gpio_bit_write(GPIOD,GPIO_PIN_7,SET);
			break;
		case 3 :
			gpio_bit_write(GPIOG,GPIO_PIN_3,SET);
			break;
		case 4 :
			gpio_bit_write(GPIOA,GPIO_PIN_5,SET);
			break;
		default:
			break;
	}
	// DELAY
	if (closeWithDelay > 0) delay_1ms(closeWithDelay);
	// CLOSE IF NEED
	if (closeWithDelay + 1) {
		switch (no) {
			case 1 :
				gpio_bit_write(GPIOE,GPIO_PIN_3,RESET);
				break;
			case 2 :
				gpio_bit_write(GPIOD,GPIO_PIN_7,RESET);
				break;
			case 3 :
				gpio_bit_write(GPIOG,GPIO_PIN_3,RESET);
				break;
			case 4 :
				gpio_bit_write(GPIOA,GPIO_PIN_5,RESET);
				break;
			default:
				break;
		}
	}
}