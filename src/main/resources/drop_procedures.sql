
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id (N'[dbo].[sp_isw_postcard_enc_update_pc_account_velocities]') AND OBJECTPROPERTY(id, N'IsProcedure') = 1)

        DROP PROCEDURE [dbo].[sp_isw_postcard_enc_update_pc_account_velocities];



IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id (N'[dbo].[sp_isw_postcard_enc_update_pc_card_velocities]') AND OBJECTPROPERTY(id, N'IsProcedure') = 1)

        DROP PROCEDURE [dbo].[sp_isw_postcard_enc_update_pc_card_velocities];




IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id (N'[dbo].[sp_isw_postcard_enc_update_pc_extended_velocities]') AND OBJECTPROPERTY(id, N'IsProcedure') = 1)

        DROP PROCEDURE [dbo].[sp_isw_postcard_enc_update_pc_extended_velocities];

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id (N'[dbo].[sp_isw_postcard_enc_update_pc_card_activity]') AND OBJECTPROPERTY(id, N'IsProcedure') = 1)

        DROP PROCEDURE [dbo].[sp_isw_postcard_enc_update_pc_card_activity];

