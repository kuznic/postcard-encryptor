
declare @SQL varchar(max) = N'create procedure sp_isw_postcard_enc_update_pc_account_velocities  @accountId varchar(100), @encAccountId varchar(100), @recordsCount int out
as

   update [dbo].[pc_account_velocities] set account_id = @encAccountId where account_id = @accountId

  select @recordsCount = @@ROWCOUNT;'

execute(@SQL);
