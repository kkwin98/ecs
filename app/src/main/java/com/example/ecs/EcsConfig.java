package com.example.ecs;

public class EcsConfig {

    public static String USER_ENR_NO;
    public static String USER_ECDW_ADRES;

    public static final String API_SERVER = "https://testapi.dpaper.kr:444";

    public static final String API_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA95G1NVGHEhw3N5TrS+XwrgP2fXx99iaYlgl9VEU/uoJW0b1A41klSYhUhM3gju+OT0UMr1YDF/Z8LDBRuPmejEDDV52fr1lfZBWd8xDoIq+mwWL3ILr9suf3qlpDYB+d/tZJ/7AMqJCa+XrZP7JixZwI5YvSvFxdm/SjAfDfm1qQlO2YJiMKHHv//NiDP2DuFtX7/3R5CvfoV+01QLd86XpRA9ULxTLsZTrMZW4+EPgwELUsf4lpdojkqKcLjuRG9oBDzkYhBuD8Wys2swRNmYfL42dCnkBZNeSMROg0Xjsp72JgjP9GVqMzivMKOniqWgxtyKUHSACINoWROBWE3QIDAQAB";
    public static final String API_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQD3kbU1UYcSHDc3lOtL5fCuA/Z9fH32JpiWCX1URT+6glbRvUDjWSVJiFSEzeCO745PRQyvVgMX9nwsMFG4+Z6MQMNXnZ+vWV9kFZ3zEOgir6bBYvcguv2y5/eqWkNgH53+1kn/sAyokJr5etk/smLFnAjli9K8XF2b9KMB8N+bWpCU7ZgmIwoce//82IM/YO4W1fv/dHkK9+hX7TVAt3zpelED1QvFMuxlOsxlbj4Q+DAQtSx/iWl2iOSopwuO5Eb2gEPORiEG4PxbKzazBE2Zh8vjZ0KeQFk15IxE6DReOynvYmCM/0ZWozOK8wo6eKpaDG3IpQdIAIg2hZE4FYTdAgMBAAECggEBAOYGt4UT/FliaBe3wayiuK8nNXbBHlSA5hO6O336Xc1Q35Q/sTPMl62sA0Pl+rk0cljLAo9DbtpsBlIUj0o8fQk5/4bACSgm9VAMGddHpTjdVianapE5zRHXILJi7ek5V1b6CoWNMSXKPoSBlavudoG/ijCmaybi94M5md/qzAkOGCZ7RI6jdVKOY65YwOsBNWIYK8Uw4F5fooNOt4hpTupwe9h2lg81eIzx3voSN7UdN0Ex0ScZTDDmKBUxxmEu2IHXzUbXDlPOBMlxW1JPHrg9WNahk3bvDhnnUCJpC6GESk07Co4bahuKzqDZgJUI0kFcLlEIOREyiZqFCSL2eSECgYEA/Ez9WJ2Jn/qf+OjXM8iQdgcN9/j2SqkFHL0uo7W8KVK7dO2YbmcHgdZ83G/nv0dMr4fMGI0U59lqv4ORGKU0fXdJQ1i5NsP4F/7geZsclpdq59AfMNQM1bVShNJDvzhw/l09g39rhsfJuilol+Kzt66wTd2OzjVbkM4GALQpi7UCgYEA+zL1UXKYUDJ3hPMrV4MDmyGFMB/zPv8Db4SoyavWYSo5OiUzmECYg3cRINlIDG5HBLjzStttaJgmuLYbS0h5uDLJjDNcGcKD4+4Elf0AU1YGvTzr3WeYnz2z2dN9zP+MstxWIMN50y2/dEumR7gvMmLJdBvPXMwm22VkmudVXYkCgYAoF1vSrwXlg//Tn7xCoEZEWw6fLtKEPqNvU6iLnx9NObZL+E1Wjcyllx20MZwTyxKmed+2rwR5axUJZbCyx921ajUcHIch6rYLqhalfD5ot5rnRy0Np0R62RtJu9fEFQXvhYV21dKSUkD98gKK0B1avMmLNf+xSM1KD1Lo3bgUWQKBgEa5rkBkV2YdD3GrVYSqKpW+9lT6ae5OtpTrcOp3K0DoNnychM5VQZuiJnxtMM/vLKezuyxUY5WTYTOYck7b9Qlbo0uKGmBWV/QQy9G/DhxomDUntfD8fgg3wy+NUForiV3Ck61d3CsNMl53/jUrMn6pObcrLVMfV8Fl5tGGWI6hAoGBANZFAWlcKK/uT1b0zdqVJYQxAwZGK95NRvEfWGX2CWCVoYefjVDE/09rSGteCpykvq1008tlR+rOvN5lUk8GSg7/ecCpBxIa/SHBHzSjoEzaPvxjh+OF01tg6HuKQk5pQmDy6LcU7DqYOOQbG/meB2uUWyydLlQUxZOfbqIyTtzb";
    public static final String API_INSTT_CODE = "974002900000001";

    public static final String API_METHOD_GET = "GET";
    public static final String API_METHOD_POST = "POST";

    /* 개인전자지갑주소확인 */
    public static  final String API_5 = "/api/appl/v2.0/address/person/verify2";
    /* 사업자전자지갑주소확인 */
    public static final String API_94 = "/api/wallet/v2.0/address/business/verify";
    /* 전자증명서발급목록조회 */
    public static final String API_36 = "/api/issue/v2.0/proofs";
    /* 전자증명서다운로드URL요청 */
    public static final String API_332 = "/api/issue/v2.0/proof/download/url";


}
