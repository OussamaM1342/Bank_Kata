# Bank Kata

## Approach
- TDD: tests written before implementation

## User Stories
- **US1**: Deposit money into account
- **US2**: Withdraw money from account
- **US3**: Print account statement

## API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| POST   | `/account/deposit/{amount}`  | Deposit money |
| POST   | `/account/withdraw/{amount}` | Withdraw money |
| GET    | `/account/statement`         | Get statement |
