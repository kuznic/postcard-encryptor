
declare @SQL varchar(max) = N'create procedure sp_isw_postcard_enc_update_pc_card_activity  @pan varchar(66), @encPan varchar(66), @recordsCount int out
as

   update [dbo].[pc_card_activity] set pan = @encPan where pan = @pan

  select @recordsCount = @@ROWCOUNT;'

execute(@SQL);
