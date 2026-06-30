import { HttpInterceptorFn } from '@angular/common/http';

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {
  const token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqZXJlbXkiLCJpYXQiOjE3ODI4MjE3OTksImV4cCI6MTc4MjgyNTM5OX0.T5PWezW7fdJf6cNYNxkl1oqdRyZxAi7THZnfFr6rvJrUESh736RLM3mj8QvVemB1HQ6ULUaCH5sQRlHWNB56WA';

  const jwtRequest = req.clone({
    setHeaders: {
      'Authorization': `Bearer ${ token }`
    }
  });

  return next(jwtRequest);
};
