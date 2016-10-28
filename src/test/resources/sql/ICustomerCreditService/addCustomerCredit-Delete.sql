delete from cls.business_object_process_info where business_object_id in (select id from cls.customer_credit where card_no in ('330106198810250017','510113199010250010'));#
delete from cls.customer_credit_relavant where credit_id in (select id from cls.customer_credit where card_no in ('330106198810250017','510113199010250010'));#
delete from cls.customer_credit where card_no in ('330106198810250017','510113199010250010')


